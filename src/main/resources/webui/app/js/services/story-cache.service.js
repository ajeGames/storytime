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

            // TODO check input parameter

            activeStory = fullStory.summary;
            indexChapters(fullStory.chapters);
        };

        function indexChapters(chapters) {
            console.log('StoryCache: indexChapters');
            for (var i=0, max=chapters.length; i < max; i++) {
                console.log('StoryCache: indexing chapter ' + chapters[i].id);
                activeChapters[chapters[i].id] = chapters[i];
            }
        };

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
