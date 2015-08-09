(function() {
    'use strict';

    angular
        .module('StoryTime')
        .controller('EditorController', EditorController);

    EditorController.$inject = ['$routeParams', 'StoryServer'];

    function EditorController($routeParams, StoryServer) {
        console.log('EditorController: constructor');

        var vm = this;

        vm.addChapterOption = addChapterOption;
        vm.draft = {};
        vm.draftChapter = {};
        vm.isNew = true;
        vm.nextChapterTeaser = null;
        vm.removeChapterOption = removeChapterOption;
        vm.saveDraft = saveDraft;
        vm.saveDraftChapter = saveDraftChapter;

        initialize($routeParams.storyKey, $routeParams.chapterId);

        function initialize(storyKey) {
            if (storyKey != null) {
                StoryServer.fetchStory(storyKey).then(function(data) {
                    vm.draft = data;
                    // TODO handle failure to find story
                    vm.isNew = false;
                    vm.draftChapter = vm.draft.firstChapter;
                });
            } else {
                vm.isNew = true;
                vm.draft = {};
            }
        }

        function saveDraft() {
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
            alert('!!!NOT IMPLEMENTED: saveDraftChapter');
        }

        function addChapterOption() {
            if (vm.nextChapterTeaser != null) {
                var sceneOption = {'key': Date.now(), 'teaser': vm.nextChapterTeaser};
                vm.draftChapter.nextChapterOptions.push(chapterOption);
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
                if (vm.draftChapter.nextChapterOptions[i].key == key) {
                    vm.draftChapter.nextChapterOptions.splice(i, 1);
                    break;
                }
            }
            saveDraftChapter();
        }
    }
})();
