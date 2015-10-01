/* handles one story at a time */

(function () {
    'use strict';

    angular
        .module('StoryTime')
        .factory('StoryCache', StoryCacheFactory);

    function StoryCacheFactory() {
        var activeChapters = {};
        var activeStory = {};
        var summaries = {};

        var service = {
            cacheStory: cacheStory,
            cacheSummaries: cacheSummaries,
            getChapter: getChapter,
            getStory: getStory,
            getSummaries: getSummaries
        };
        return service;

        function cacheSummaries(storySummaries) {
            console.log('StoryCache: cacheSummaries');
            summaries = storySummaries;
        };

        function cacheStory(fullStory) {
            console.log('StoryCache: cacheStory')

            // cursory check
            if (fullStory == null || fullStory.summary === undefined
                    || fullStory.chapters === undefined) {
                console.alert('attempted to cache story with parts missing');
                return;
            }

            activeStory = fullStory.summary;
            indexChapters(fullStory.chapters);
        };

        function indexChapters(chapters) {
            for (var i=0, max=chapters.length; i < max; i++) {
                cacheChapter(chapters[i]);
            }
        };

        function cacheChapter(chapter) {
            activeChapters[chapter.id] = chapter;
        }

        function removeChapter(id) {

        }

        function getSummaries() {
            return summaries;
        };

        function getStory() {
            return activeStory;
        };

        function getChapter(id) {
            if (activeChapters === undefined) {
                return null;
            }
            return activeChapters[id];
        };
    }

})();
