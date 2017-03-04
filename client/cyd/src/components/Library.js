import React, { Component } from 'react';

class Library extends Component {
  render() {
    return (
      <div className="panel panel-default">
          <div className="panel-heading">
              <h3 className="text-center panel-title">Welcome to the Library. Choose a Story.</h3></div>
          <div className="panel-body">
              <div className="container">
                  <div className="row">
                      <div className="col-md-4">
                          <div className="catalog-item">
                              <p><span className="title"><a href="#">A Series of Unfortunate Events</a></span></p>
                              <p><em>by Lemony Snickett</em></p>
                              <p>This is a very sad story about a very sad series of unfortunate events. You probably don't want to read this one. It will make you sad.</p>
                          </div>
                      </div>
                      <div className="col-md-4">
                          <div className="catalog-item">
                              <p><span className="title"><a href="#">The Cave</a></span></p>
                              <p><em>by Bubbabubba Gump</em></p>
                              <p>Explore deep and discover the untold mysteries.</p>
                          </div>
                      </div>
                      <div className="col-md-4">
                          <div className="catalog-item">
                              <p><span className="title"><a href="#">Along the Waterfall</a></span></p>
                              <p><em>by Mary Spring</em></p>
                              <p>Mary, Mary, quite contrary, how does your garden grow? With silver bells and cockle shells and pretty maids all in a row. Hey diddle diddle, the cat and the fiddle, the cow jumped over the moon. The little dog laughed to see
                                  such sport, and the dish ran away with the spoon.</p>
                          </div>
                      </div>
                  </div>
                  <div className="row">
                      <div className="col-md-4">
                          <div className="catalog-item">
                              <p><span className="title"><a href="#">The Cave</a></span></p>
                              <p><em>by Bubbabubba Gump</em></p>
                              <p>Explore deep and discover the untold mysteries.</p>
                          </div>
                      </div>
                      <div className="col-md-4">
                          <div className="catalog-item">
                              <p><span className="title"><a href="#">Along the Waterfall</a></span></p>
                              <p><em>by Mary Spring</em></p>
                              <p>Mary, Mary, quite contrary, how does your garden grow? With silver bells and cockle shells and pretty maids all in a row. Hey diddle diddle, the cat and the fiddle, the cow jumped over the moon. The little dog laughed to see
                                  such sport, and the dish ran away with the spoon.</p>
                          </div>
                      </div>
                      <div className="col-md-4">
                          <div className="catalog-item">
                              <p><span className="title"><a href="#">A Series of Unfortunate Events</a></span></p>
                              <p><em>by Lemony Snickett</em></p>
                              <p>This is a very sad story about a very sad series of unfortunate events. You probably don't want to read this one. It will make you sad.</p>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    );
  }
}

export default Library;
