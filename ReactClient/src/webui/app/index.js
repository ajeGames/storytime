import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute, hashHistory } from 'react-router';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import reducer from './reducers/reducer';
import App from './components/App';
import BasicLayout from './components/BasicLayout';
import Home from './components/Home';
import CatalogContainer from './components/catalog/CatalogContainer';
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

ReactDOM.render((
    <Provider store={store}>
      <Router history={hashHistory}>
        <Route path="/" component={BasicLayout}>
          <IndexRoute component={Home} />
          <Route path="library" component={CatalogContainer} />
          <Route path="editor" component={EditorContainer} />
          <Route path="story" component={ReaderContainer}>
            <Route path=":storyKey" component={ReaderContainer}>
              <Route path=":chapterId" component={ReaderContainer} />
            </Route>
          </Route>
        </Route>
      </Router>
    </Provider>
), document.getElementById('app'));
