import React from 'react';
import TitleInput from './TitleInput';

class StorySummaryEditor extends React.Component {

  constructor() {
    super();
  }

  handleFieldChange(event) {
    console.log('field changed: ' + event);
  }

  /*
   <div>Title: The Cave</div>
   <div>
   <label>Title:
   <input type="text" value="The Cave" onChange={this.handleChange} />
   </label>
   </div>

   */
  render() {
    return (
        <div>
          <h3>StorySummaryEditor</h3>
          <div className="section">
            <div>Key: jk3jko8w</div>
            <TitleInput text="The Cave" edit="true" onChange={this.handleFieldChange} />
            <div>Author: Bubba Gump</div>
            <div>
              <label>Author:
                <input type="text" value="Bubba Gump" onChange={this.handleFieldChange} />
              </label>
            </div>
            <div>Tag Line: Step inside, find adventure!</div>
            <div>
              <label>Tag Line:
                <input type="text" value="Step inside, find adventure!" onChange={this.handleFieldChange} />
              </label>
            </div>
            <div>Description: You could sit on your couch all day, tapping away at your smart phone, or you could get
              outside and have an adventure.
            </div>
            <div>
              <label>Description:
                <textarea onChange={this.handleFieldChange}
                          value="You could sit on your couch all day, tapping away at your smart phone, or you could get
              outside and have an adventure."></textarea>
              </label>
            </div>
            <button>Make Changes</button>
            <button>Save Story Summary</button>
          </div>
        </div>
    );
  }
}

export default StorySummaryEditor;
