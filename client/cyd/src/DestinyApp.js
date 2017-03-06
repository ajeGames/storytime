import React, { Component } from 'react';
import Header from './components/Header';
import Library from './components/Library';

class DestinyApp extends Component {
  render() {
    return (
      <div>
        <Header />
        <Library />
      </div>
    );
  }
}

export default DestinyApp;
