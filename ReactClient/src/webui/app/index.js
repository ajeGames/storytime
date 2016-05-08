import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute, browserHistory } from 'react-router';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import reducer from './reducers/reducer';
import App from './components/App';
import BasicLayout from './components/BasicLayout';
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

ReactDOM.render((
    <Provider store={store}>
      <Router history={browserHistory}>
        <Route path="/" component={BasicLayout}>
          <IndexRoute component={Home} />
          <Route path="library" component={Catalog} />
          <Route path="editor" component={EditorContainer} />
          <Route path="story" component={ReaderContainer} />
        </Route>
      </Router>
    </Provider>
), document.getElementById('app'));
