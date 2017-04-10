import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import Library from './components/Library';
import NumberGuessing from './pages/NumberGuessing';

const App = () => (
    <Router>
      <div>
        <h3>StoryTime</h3>
        <p><Link to="/">StoryTime</Link> | <Link to="/guess">Number Guessing Game</Link></p>
        <Route exact path="/" component={Library} />
        <Route path="/guess" component={NumberGuessing} />
      </div>
    </Router>
)

export default App;
