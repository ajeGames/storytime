import React, {Component} from 'react';

class Header extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-default navigation-clean-button">
          <div className="container-fluid">
            <div className="navbar-header"><a className="navbar-brand navbar-link" href="#">StoryTime </a>
              <button className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span className="sr-only">Toggle navigation</span><span className="icon-bar"></span><span className="icon-bar"></span><span className="icon-bar"></span></button>
            </div>
            <div className="collapse navbar-collapse" id="navcol-1">
              <ul className="nav navbar-nav">
                <li className="active" role="presentation"><a href="#">Library </a></li>
                <li role="presentation"><a href="#">Reader </a></li>
                <li role="presentation"><a href="#">Writing Desk</a></li>
                <li role="presentation"><a href="#">Clubhouse </a></li>
              </ul>
              <p className="navbar-text navbar-right actions"><a className="navbar-link login" href="#">Log In</a> <a className="btn btn-default action-button" role="button" href="#">Sign Up</a></p>
            </div>
          </div>
        </nav>
      </div>
    );
  }
}
