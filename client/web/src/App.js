import React, { Component } from 'react';
import NumberGuessing from './pages/NumberGuessing';
// import SumGuessing from './pages/SumGuessing';

class App extends Component {
  render() {
    return (
      <div>
        <NumberGuessing />
        {/* <SumGuessing /> */}
      </div>
    );
  }
}

export default App;
