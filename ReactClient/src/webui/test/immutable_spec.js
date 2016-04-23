//import {expect} from 'chai';
//import {List, Map} from 'immutable';
//
//describe('immutability', () => {
//
//  describe('a number', () => {
//
//    function increment(currentState) {
//      return currentState + 1;
//    }
//
//    it('is immutable', () => {
//      let state = 42;
//      let nextState = increment(state);
//
//      expect(nextState).to.equal(43);
//      expect(state).to.equal(42);
//    });
//
//  });
//
//  describe('a list', () => {
//
//    function addMovie(currentState, movie) {
//      return currentState.push(movie);
//    }
//
//    it('is immutable', () => {
//      let state = List.of('Trainspotting', '28 Days Later');
//      let nextState = addMovie(state, 'Sunshine');
//
//      expect(nextState).to.equal(List.of(
//          'Trainspotting',
//          '28 Days Later',
//          'Sunshine'
//      ));
//      expect(state).to.equal(List.of(
//          'Trainspotting',
//          '28 Days Later'
//      ));
//    });
//
//  });
//
//  describe('a tree', () => {
//
//    function addMovie(currentState, movie) {
//      return currentState.set(
//          'movies',
//          currentState.get('movies').push(movie)
//      );
//    }
//
//    it('is immutable', () => {
//      let state = Map({
//        movies: List.of('Trainspotting', '28 Days Later')
//      });
//      let nextState = addMovie(state, 'Sunshine');
//
//      expect(nextState).to.equal(Map({
//        movies: List.of(
//            'Trainspotting',
//            '28 Days Later',
//            'Sunshine'
//        )
//      }));
//    });
//  });
//
//  describe('using keypath', () => {
//    it('works with nested maps', () => {
//      let state = Map({
//        story: Map({
//          summary: Map({
//            title: 'The Pokey Little Puppy'
//          })
//        })
//      });
//      expect(state.getIn(['story', 'summary', 'title'])).to.equal('The Pokey Little Puppy');
//    });
//
//    it('works to create intermediate maps', () => {
//      let state = Map();
//      state = state.setIn(['my', 'fun', 'secret', 'word', 'is'], 'bubbagump');
//      state = state.setIn(['my', 'fun', 'secret', 'number', 'is'], 42);
//      expect(state.getIn(['my', 'fun', 'secret', 'word', 'is'])).to.equal('bubbagump');
//      expect(state.getIn(['my', 'fun', 'secret', 'number', 'is'])).to.equal(42);
//    })
//  });
//
//});