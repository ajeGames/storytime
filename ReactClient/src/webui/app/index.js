import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, hashHistory } from 'react-router';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import reducer from './reducers/reducer';
import App from './components/App';
import Home from './components/Home';
import Catalog from './components/Catalog';
import { ReaderContainer } from './components/reader/Reader';
import Editor from './components/editor/Editor';
import { SAMPLE2 } from '../test/SampleData';  // TODO remove this reference -- should come out once story is loaded from server

const store = createStore(reducer);
store.dispatch({
  type: 'LOAD_STORY',
  story: SAMPLE2
});

const routes = <Route component={App}>
  <Route path="/" component={Catalog} />
  <Route path="/hello" component={Home} />
  <Route path="/story" component={ReaderContainer}>
    <Route path=":storyKey" component={ReaderContainer}>
      <Route path=":chapterId" component={ReaderContainer} />
    </Route>
  </Route>
  <Route path="/editor" component={Editor} />
</Route>;

ReactDOM.render(
    <Provider store={store}>
      <Router history={hashHistory}>{routes}</Router>
    </Provider>,
    document.getElementById('app')
);
