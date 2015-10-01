(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('EditorController', EditorController);

    EditorController.$inject = ['$routeParams', 'Backend', 'StoryCache'];

    function EditorController($routeParams, Backend, StoryCache) {
        console.log('EditorController: constructor');
        var vm = this;
        vm.addChapterOption = addChapterOption;
        vm.draftSummary = {};
        vm.draftChapter = {};
        vm.isNew = true;
        vm.nextChapterTeaser = null;
        vm.removeChapterOption = removeChapterOption;
        vm.saveDraftSummary = saveDraftSummary;
        vm.saveDraftChapter = saveDraftChapter;

        initialize($routeParams.storyKey, $routeParams.chapterId);

        function initialize(storyKey, chapterId) {
            console.log('EditorController.initialize');
            if (storyKey === null) {
                vm.isNew = true;
                vm.draft = {};
                vm.draftChapter = {};
            } else {
                Backend.fetchStory(storyKey).then(
                    function(story) {
                        prepStoryAsDraft(story, chapterId);
                    });
                // TODO handle failure to find story
            }
        }

        function prepStoryAsDraft(story, chapterId) {
            StoryCache.cacheStory(story);
            vm.isNew = false;
            vm.draftSummary = StoryCache.getStory();
            var chapterToFetch = (chapterId != null) ? chapterId : vm.draftSummary.firstChapter.targetChapterId;
            vm.draftChapter = StoryCache.getChapter(chapterToFetch);
        }

        function saveDraftSummary() {
            var result;
            if (vm.draftSummary.key == null) {
                result = Backend.createStory(vm.draftSummary);
                // TODO determine if there was a problem; otherwise, no longer new
                isNew = false;
            } else {
                result = Backend.updateStory(vm.draftSummary);
            }
            result.then(function(data) {
                vm.draftSummary = data;
            });
        }

        function saveDraftChapter() {
            Backend.updateChapter(vm.draftSummary.key, vm.draftChapter);
            initialize(vm.draftSummary.key, vm.draftChapter.id);
        }

        function addChapterOption() {
            if (vm.nextChapterTeaser != null) {
                Backend.createChapter(vm.draftSummary.key, vm.draftChapter.id, vm.nextChapterTeaser);
                vm.draftChapter.nextChapterOptions.push( {'id': '-1', 'teaser': vm.nextChapterTeaser} );
                vm.nextChapterTeaser = null;
            } else {
                alert('Provide some text for the teaser/signpost.');
            }
            initialize(vm.draftSummary.key, vm.draftChapter.id);
        }

        function removeChapterOption(id) {
            if (id === undefined || id === null) {
                alert('!!!NOT FOUND: chapter ID of the option to remove');
            }
            Backend.deleteChapter(vm.draftSummary.key, id);
            initialize(vm.draftSummary.key, null);
        }
    }
})();
