import React from 'react';

class Catalog extends React.Component {
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
            <li><a href="#/reader/o9s0toym">The Cave</a>, by Bubba Gump.<br/>See what you'll find when you stuble upon a cave in the woods.</li>
            <li><a href="#/reader">How the West Was Won</a>, by Billy the Kid.<br/>Gunslingers and pioneers make choices that keep them alive or bring them to doom.</li>
            <li><a href="#/reader">The Three Bears</a>, by Bubba Grimm.<br/>Goldie Lockes never knew what could have been if she had only explored the basement.</li>
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
          </ul>
        </div>
      </div>
    );
  }
}

export default Catalog;
