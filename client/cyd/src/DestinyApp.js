import React, {Component} from 'react'
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom'

import Library from './components/Library';
import Clubhouse from './components/Clubhouse';
import WritingDesk from './components/WritingDesk';

class DestinyApp extends Component {
  render() {
    return (
// const DestinyApp = () => {
  <Router>
    <div>
      <nav className="navbar navbar-default navigation-clean-button">
        <div className="container-fluid">
          <div className="navbar-header"><a className="navbar-brand navbar-link" href="#">StoryTime </a>
            <button className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span className="sr-only">Toggle navigation</span><span className="icon-bar"></span><span className="icon-bar"></span><span className="icon-bar"></span></button>
          </div>
          <div className="collapse navbar-collapse" id="navcol-1">
            <ul className="nav navbar-nav">
              <li className="active" role="presentation"><Link to="/library">Library</Link></li>
              <li role="presentation"><Link to="/library">Library</Link></li>
              <li role="presentation"><Link to="/story">Story</Link></li>
              <li role="presentation"><Link to="/desk">Writing Desk</Link></li>
              <li role="presentation"><Link to="/clubhouse">Clubhouse</Link></li>
            </ul>
            <p className="navbar-text navbar-right actions"><a className="navbar-link login" href="#">Log In</a> <a className="btn btn-default action-button" role="button" href="#">Sign Up</a></p>
          </div>
        </div>
      </nav>

      <Route path="/library" component={Library} />
      <Route path="/desk" component={WritingDesk} />
      <Route path="/clubhouse" component={Clubhouse} />
    </div>
  </Router>
// }
    );
  }
}

export default DestinyApp;
