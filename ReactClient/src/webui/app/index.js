import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { Router, Route, IndexRoute, hashHistory } from 'react-router';
import { Provider } from 'react-redux';
import reducer from './reducers/reducer';
import BasicLayout from './components/BasicLayout';
import Home from './components/Home';
import CatalogContainer from './components/catalog/CatalogContainer';
import { ReaderContainer } from './components/reader/Reader';
import { EditorContainer } from './components/editor/Editor';
import { SAMPLE2 } from '../test/SampleData';  // TODO remove once load is working

const store = createStore(reducer);

store.dispatch({
  type: 'LOAD_STORY',
  story: SAMPLE2,
});

store.dispatch({
  type: 'EDIT_SUMMARY',
});

ReactDOM.render((
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path="/" component={BasicLayout}>
        <IndexRoute component={Home} />
        <Route path="library" component={CatalogContainer} />
        <Route path="story">
          <Route path=":storyKey" component={ReaderContainer}>
            <Route path=":chapterId" component={ReaderContainer} />
          </Route>
        </Route>
        <Route path="editor" component={EditorContainer} />
      </Route>
    </Router>
  </Provider>
), document.getElementById('app'));
