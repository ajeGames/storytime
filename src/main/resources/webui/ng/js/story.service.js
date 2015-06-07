/* handles one story at a time */

(function () {
    'use strict';

    angular
        .module('storyTimeApp')
        .factory('storyCache', storyCache);

    function storyCache() {
        return {
            summaries: {},
            activeStory: {},
            activeChapters: {}
        };
    }

})();
