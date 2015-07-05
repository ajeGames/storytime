/* handles one story at a time */

(function () {
    'use strict';

    angular
        .module('StoryTime')
        .factory('storyCache', storyCache);

    function storyCache() {
        return {
            summaries: {},
            activeStory: {},
            activeChapters: {}
        };
    }

})();
