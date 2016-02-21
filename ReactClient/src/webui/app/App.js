import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link } from 'react-router';
import Header from './components/Header';
import Footer from './components/Footer';
import Reader from './components/Reader';
import Editor from './components/editor/Editor';
import Catalog from './components/Catalog';

class App extends React.Component {
  render() {
    return (
        <div>
          <Header heading="Choose Your Own Destiny" />
          {this.props.children}
          <Footer />
        </div>
    )
  };
}

render((
    <Router>
      <Route path="/" component={App}>
        <IndexRoute component={Catalog} />
        <Route path="/reader" component={Reader}>
          <Route path=":storyKey" component={Reader}>
            <Route path=":chapterId" component={Reader} />
          </Route>
        </Route>
        <Route path="/editor" component={Editor} />
      </Route>
    </Router>
), document.getElementById('app'));
