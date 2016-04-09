import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, hashHistory} from 'react-router';
import App from './components/App';
import Catalog from './components/Catalog';
import Home from './components/Home';
import Reader from './components/reader/Reader';
import Editor from './components/editor/Editor';

const routes = <Route component={App}>
  <Route path="/" component={Catalog}/>
  <Route path="/hello" component={Home}/>
  <Route path="/story" component={Reader}>
    <Route path=":storyKey" component={Reader}>
      <Route path=":chapterId" component={Reader}/>
    </Route>
  </Route>
  <Route path="/editor" component={Editor}/>
</Route>;

ReactDOM.render(
    <Router history={hashHistory}>{routes}</Router>,
    document.getElementById('app')
);

//render((
//    <Router>
//      <Route path="/" component={App}>
//        <IndexRoute component={Catalog} />
//        <Route path="/reader" component={Reader}>
//          <Route path=":storyKey" component={Reader}>
//            <Route path=":chapterId" component={Reader} />
//          </Route>
//        </Route>
//        <Route path="/editor" component={Editor} />
//      </Route>
//    </Router>
//), document.getElementById('app'));
