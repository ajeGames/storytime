(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('EditorController', EditorController);

    EditorController.$inject = ['$routeParams', 'RemoteData', 'StoryContext'];

    function EditorController($routeParams, RemoteData, StoryContext) {
        var vm = this;
        vm.addChapterOption = addChapterOption;
        vm.draftChapter = {};
        vm.draftSummary = StoryContext.getActiveStorySummary();
        vm.isEditChapter = isEditChapter;
        vm.isEditSummary = isEditSummary;
        vm.mode = "summary";
        vm.nextChapterTeaser = null;
        vm.paramChapterId = $routeParams.chapterId;
        vm.paramStoryKey = $routeParams.storyKey;
        vm.removeChapterOption = removeChapterOption;
        vm.saveDraftChapter = saveDraftChapter;
        vm.saveDraftSummary = saveDraftSummary;

        activate();

        function activate() {
            if (vm.paramStoryKey != undefined) {
                if (vm.paramStoryKey != vm.draftSummary.key) {
                    loadStory().then(function() {
                        setDraftChapter();
                    });
                } else {
                    setDraftChapter();
                }
            } else {
                vm.draft = {};
                vm.draftChapter = {};
                vm.mode = "summary";
            }
        }

        function loadStory() {
            return RemoteData.fetchStory(vm.paramStoryKey)
                .then(function(story) {
                    StoryContext.cacheStory(story);
                    vm.draftSummary = StoryContext.getActiveStorySummary();
                });
        }

        function setDraftChapter() {
            if (vm.paramChapterId != undefined) {
                vm.draftChapter = StoryContext.getChapter(vm.paramChapterId);
                vm.mode = "chapter";
            }
        }

        function isEditChapter() {
            return vm.mode === "chapter";
        }

        function isEditSummary() {
            return vm.mode === "summary";
        }

        function saveDraftSummary() {
            var result;
            if (vm.draftSummary.key == null) {
                result = RemoteData.createStory(vm.draftSummary);
                // TODO determine if there was a problem; otherwise, no longer new
                isNew = false;
            } else {
                result = RemoteData.updateStory(vm.draftSummary);
            }
            result.then(function(data) {
                vm.draftSummary = data;
            });
        }

        function saveDraftChapter() {
            RemoteData.updateChapter(vm.draftSummary.key, vm.draftChapter);
            initialize(vm.draftSummary.key, vm.draftChapter.id);
        }

        function addChapterOption() {
            if (vm.nextChapterTeaser != null) {
                RemoteData.createChapter(vm.draftSummary.key, vm.draftChapter.id, vm.nextChapterTeaser);
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
            RemoteData.deleteChapter(vm.draftSummary.key, id);
            initialize(vm.draftSummary.key, null);
        }
    }
})();
