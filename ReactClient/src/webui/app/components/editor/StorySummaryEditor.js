import React from 'react';

export default class StorySummaryEditor extends React.Component {

  render() {
    return (
        <div>
          <h3>StorySummaryEditor</h3>
          <div className="section">
            <div>Key: {this.props.summary.key}</div>
            <div>Title: {this.props.summary.title}</div>
            <div>
              <label>Title:
                <input type="text" value={this.props.summary.title}/>
              </label>
            </div>
            <div>Author: {this.props.summary.author}</div>
            <div>
              <label>Author:
                <input type="text" value={this.props.summary.author}/>
              </label>
            </div>
            <div>Tag Line: {this.props.summary.tagLine}</div>
            <div>
              <label>Tag Line:
                <input type="text" value={this.props.summary.tagLine}/>
              </label>
            </div>
            <div>Description: {this.props.summary.about}</div>
            <div>
              <label>Description:
                <textarea value={this.props.summary.about}></textarea>
              </label>
            </div>
            <button>Make Changes</button>
            <button>Save Story Summary</button>
          </div>
        </div>
    );
  }
}
