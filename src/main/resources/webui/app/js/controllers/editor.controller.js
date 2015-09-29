(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('EditorController', EditorController);

    EditorController.$inject = ['$routeParams', 'StoryServer', 'StoryCache'];

    function EditorController($routeParams, StoryServer, StoryCache) {
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
                StoryServer.fetchStory(storyKey).then(
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
            if (vm.draft.key == null) {
                result = StoryServer.createStory(vm.draft);
                // TODO determine if there was a problem; otherwise, no longer new
                isNew = false;
            } else {
                result = StoryServer.updateStory(vm.draft);
            }
            result.then(function(data) {
                vm.draft = data;
            });
        }

        function saveDraftChapter() {
            alert('!!!TODO: saveDraftChapter');
        }

        function addChapterOption() {
            if (vm.nextChapterTeaser != null) {
                vm.draftChapter.nextChapterOptions.push( {'id': '-1', 'teaser': vm.nextChapterTeaser} );
                vm.nextChapterTeaser = null;
            } else {
                alert('Provide some text for the teaser/signpost.');
            }
            saveDraftChapter();
        }

        function removeChapterOption(id) {
            if (id === undefined || id === null) {
                alert('!!!NOT FOUND: chapter ID of the option to remove');
            }
            for (var i in vm.draftChapter.nextChapterOptions) {
                if (vm.draftChapter.nextChapterOptions[i].id === id) {
                    vm.draftChapter.nextChapterOptions.splice(i, 1);
                    break;
                }
            }
            saveDraftChapter();
        }
    }
})();
