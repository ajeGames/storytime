import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link } from 'react-router';
import Reader from './components/Reader';

class App extends React.Component {
  render() {
    return (
    <div>
      <h1>Choose Your Own Destiny</h1>
      <h2>Follow an adventure</h2>
      {this.props.children}
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
