(function () {
  'use strict';

  angular
      .module('StoryTime')
      .controller('CatalogController', CatalogController);

  function CatalogController(StoryService) {
    var vm = this;

    // TODO learn how to test
    vm.listStoriesMock = [
      {
        'key': 'ABC123', 'title': 'Mock: Tale of Two Cities', 'author': 'Charles Dickens',
        'tagline': 'It was the best of times; it was the worst of times.',
        'firstScene': {
          'key': '098ZYX', 'teaser': '19th century London',
          'prose': 'It was the best of times.  It was the worst of times.  Blah blah blah.',
          'nextSceneOptions': [
            {'key': '123SCENE', 'teaser': 'See what was so good about these times.'},
            {'key': '234SCENE', 'teaser': 'See what was so bad about these times.'}
          ]
        }
      },
      {
        'key': 'DEF456', 'title': 'Mock: The Raven', 'author': 'Edgar Allan Poe', 'tagline': 'Evermore.',
        'firstScene': {'key': '765WVU', 'teaser': 'Something about my love, Lenore...'}
      },
      {
        'key': 'GHI789', 'title': 'Mock: Star Wars', 'author': 'George Lucas',
        'tagline': 'Can our young hero overcome adversity and bring balance to the force?',
        'firstScene': {
          'key': 'QWERTY1', 'teaser': 'May the force be with you.',
          'prose': 'A long time ago in a galaxy far far away, the Rebel alliance was causing trouble for the Galactic Empire.',
          'nextSceneOptions': [
            {'key': 'QWERTY2', 'teaser': 'Use the force.'}
          ]
        }
      }
    ];

    // === Story summary edit logic ===

//  vm.catalog = listStoriesMock;
    vm.catalog = loadCatalog();

    function loadCatalog() {
      StoryService.fetchAllStories().then(
          function (stories) {
            applyRemoteData(stories);
          });
    }

    function applyRemoteData(stories) {
      vm.catalog = stories;
    }
  }
})();