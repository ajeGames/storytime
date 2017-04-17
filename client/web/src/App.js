import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import storyTimeApp from './appstate/reducers';
import LibraryContainer from './components/LibraryContainer';
import ReaderContainer from './components/ReaderContainer';
import NumberGuessing from './components/NumberGuessing';

let store = createStore(
  storyTimeApp,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

const App = () => (
  <Provider store={ store }>
    <Router>
      <div>
        <h3>StoryTime</h3>
        <p><Link to="/">StoryTime</Link> | <Link to="/guess">Number Guessing Game</Link></p>
        <Route exact path="/" component={ LibraryContainer } />
        <Route path="/reader" component={ ReaderContainer } />
        <Route path="/guess" component={ NumberGuessing } />
      </div>
    </Router>
  </Provider>
)

export default App;
