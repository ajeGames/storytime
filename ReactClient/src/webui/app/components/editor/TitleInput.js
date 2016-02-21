import React from 'react';

class TitleInput extends React.Component {
  constructor() {
    super();
  }

  handleChange(event) {
  }

  render() {
    return (
        <label>Title:
          <input type="text" value="" onChange={this.handleChange}/>
        </label>
    );
  }
}

export default TitleInput;
