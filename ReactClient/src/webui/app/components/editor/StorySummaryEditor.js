import React from 'react';
import TitleInput from './TitleInput';

class StorySummaryEditor extends React.Component {

  constructor() {
    super();
  }

  render() {
    return (
        <div>
          <h2>StorySummaryEditor</h2>
          <div>
            <label>Title:
              <input type="text" />
            </label>
          </div>
          <div>
            <label>Author:
              <input type="text" />
            </label>
          </div>
          <div>
            <label>Tag Line:
              <input type="text" />
            </label>
          </div>
          <div>
            <label>Description:
              <textarea></textarea>
            </label>
          </div>
          <button>Save Story Summary</button>
        </div>
    );
  }
}

export default StorySummaryEditor;
