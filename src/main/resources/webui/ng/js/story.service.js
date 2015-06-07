/* handles one story at a time */

(function () {
    'use strict';

    angular
        .module('storyTimeApp')
        .factory('storyCache', storyCache);

    function storyCache() {
        return {
            activeStory: {},
            activeChapters: {}
        };
    }

})();
