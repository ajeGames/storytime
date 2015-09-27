/* handles one story at a time */

(function () {
    'use strict';

    angular
        .module('StoryTime')
        .factory('StoryCache', StoryCacheFactory);

    function StoryCacheFactory() {
        return {
            activeChapters: {},
            activeStory: {},
            summaries: {}
        };
    }

})();
