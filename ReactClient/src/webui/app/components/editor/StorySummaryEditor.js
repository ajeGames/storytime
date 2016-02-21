import React from 'react';
import TitleInput from './TitleInput';

class StorySummaryEditor extends React.Component {

  constructor() {
    super();
  }

  handleChange(event) {
  }

  render() {
    return (
        <div>
          <h2>StorySummaryEditor</h2>
          <div className="section">
            <div>Key: jk3jko8w</div>
            <div>Title: The Cave</div>
            <div>Author: Bubba Gump</div>
            <div>Tag Line: Step inside, find adventure!</div>
            <div>Description: You could sit on your couch all day, tapping away at your smart phone, or you could get
              outside and have an adventure.
            </div>
          </div>
          <div className="section">
            <div>
              <label>Title:
                <input type="text" value="The Cave" onChange={this.handleChange} />
              </label>
            </div>
            <div>
              <label>Author:
                <input type="text" value="Bubba Gump" onChange={this.handleChange} />
              </label>
            </div>
            <div>
              <label>Tag Line:
                <input type="text" value="Step inside, find adventure!" onChange={this.handleChange} />
              </label>
            </div>
            <div>
              <label>Description:
                <textarea onChange={this.handleChange}
                          value="You could sit on your couch all day, tapping away at your smart phone, or you could get
              outside and have an adventure."></textarea>
              </label>
            </div>
            <button>Save Story Summary</button>
          </div>
        </div>
    );
  }
}

export default StorySummaryEditor;
