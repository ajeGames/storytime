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
import { EditorContainer } from './components/editor/Editor';
import { SAMPLE2 } from '../test/SampleData';  // TODO remove this reference -- should come out once story is loaded from server

const store = createStore(reducer);
store.dispatch({
  type: 'LOAD_STORY',
  story: SAMPLE2
});
store.dispatch({
  type: 'EDIT_SUMMARY'
});

const routes = <Route component={App}>
  <Route path="/" component={Home} />
  <Route path="/catalog" component={Catalog} />
  <Route path="/editor" component={EditorContainer} />
</Route>;

ReactDOM.render(
    <Provider store={store}>
      <Router history={hashHistory}>{routes}</Router>
    </Provider>,
    document.getElementById('app')
);


/*
 <Route path="/story" component={ReaderContainer}>
 <Route path=":storyKey" component={ReaderContainer}>
 <Route path=":chapterId" component={ReaderContainer} />
 </Route>
 </Route>
*/