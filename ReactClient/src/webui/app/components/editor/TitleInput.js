import React from 'react';

class TitleInput extends React.Component {
  constructor() {
    super();
  }

  handleChange(event) {
  }

  render() {
    return (
        <div>
          <label>Title:
            <input type="text" value="" onChange={this.handleChange}/>
          </label>
        </div>
    );
  }
}

export default TitleInput;
