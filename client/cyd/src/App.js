import React, {Component} from 'react'
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom'

import Library from './components/Library';
import Reader from './components/Reader';
import Clubhouse from './components/Clubhouse';
import WritingDesk from './components/WritingDesk';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <nav className="navbar navbar-default navigation-clean-button">
            <div className="container-fluid">
              <div className="navbar-header"><Link className="navbar-brand navbar-link" to="/">StoryTime </Link>
                <button className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span className="sr-only">Toggle navigation</span><span className="icon-bar"></span><span className="icon-bar"></span><span className="icon-bar"></span></button>
              </div>
              <div className="collapse navbar-collapse" id="navcol-1">
                <ul className="nav navbar-nav">
                  <li role="presentation"><Link to="/">Library</Link></li>
                  <li role="presentation"><Link to="/desk">Writing Desk</Link></li>
                  <li role="presentation"><Link to="/clubhouse">Clubhouse</Link></li>
                </ul>
                <p className="navbar-text navbar-right actions"><a className="navbar-link login" href="#">Log In</a> <a className="btn btn-default action-button" role="button" href="#">Sign Up</a></p>
              </div>
            </div>
          </nav>

          <Route exact path="/" component={Library} />
          <Route path="/reader/:storyKey/:chapterId" component={Reader} />
          <Route path="/desk" component={WritingDesk} />
          <Route path="/clubhouse" component={Clubhouse} />
        </div>
      </Router>
    );
  }
}

export default App;
