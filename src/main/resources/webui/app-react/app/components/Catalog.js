import React from 'react';
import $ from 'jquery';

class Catalog extends React.Component {

  constructor() {
    super();

    this.state = { summaries: [] }
  }

  loadStoriesFromServer() {
    let apiEndpoint = 'http://localhost/storytime/api/storytime/stories';
    $.ajax({
      url: apiEndpoint,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState( { summaries: data } );
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
  }

  componentDidMount() {
    this.loadStoriesFromServer();
  }

  render() {
    return (
      <div id="catalog" className="section">
        <h1>Catalog</h1>
        <h2>How our fair readers select an adventure</h2>
        <form>
          <p>
              <label>Keywords: <input id="search_keyword" placeholder="Enter a keyword or phrase" type="text"/></label>
              <button>Search</button>
          </p>
        </form>
        <div>Results:
          <ul>
            {this.state.summaries.map(function(summary) {
              return <li key={summary.key}><Link to={'#/reader/{summary.key}'}>{summary.title}</Link> by {summary.author}<br/>{summary.tagLine}</li>
            })}
          </ul>
          <p>Sample:</p>
          <ul>
            <li><a href="#/reader/o9s0toym">The Cave</a>, by Bubba Gump.<br/>See what you'll find when you stuble upon a cave in the woods.</li>
          </ul>
        </div>
        <div>
          <h2>Notes:</h2>
          <ul>
            <li>Search: title, author, genre, recency of publication</li>
            <li>Genre
              <ul>
                <li>Rank by most popular, publish date</li>
                <li>List with paging</li>
              </ul>
            </li>
            <li>Target ages / "movie" ratings</li>
            <li>Reader voting -- 'like' a story</li>
          </ul>
        </div>
      </div>
    );
  }
}

export default Catalog;
