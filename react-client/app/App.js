import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link } from 'react-router';
import Header from './components/Header';
import Footer from './components/Footer';
import Reader from './components/Reader';

class App extends React.Component {
  render() {
    return (
    <div>
      <Header />
      {this.props.children}
      <Footer />
    </div>
  )};
}

ReactDOM.render((
    <Router>
      <Route path="/" component={App}>
        <Route path='/reader' component={Reader}/>
      </Route>
    </Router>
), document.getElementById('app'));
