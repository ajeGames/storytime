import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
// import { Provider } from 'react-redux';
// import { createStore } from 'redux';
// import storyTimeApp from './appstate/reducers';
import Library from './components/Library';
import Reader from './components/Reader';
import NumberGuessing from './components/NumberGuessing';

// let store = createStore(storyTimeApp);  // FIXME this is wrong

const App = () => (
  // <Provider store={ store }>
  <Router>
    <div>
      <h3>StoryTime</h3>
      <p><Link to="/">StoryTime</Link> | <Link to="/guess">Number Guessing Game</Link></p>
      <Route exact path="/" component={Library} />
      <Route path="/reader/{storyKey}/{chapterId}" component={Reader} />
      <Route path="/guess" component={NumberGuessing} />
    </div>
  </Router>
  // </Provider>
)

export default App;
