import React from 'react'
import Header from './Header'
import Footer from './Footer'

const BasicLayout = React.createClass({
  render: function () {
    return (
        <div>
          <div>
            <Header heading="Hey, kids!  Let's have an adventure!" />
          </div>
          <div>
            <div>
              <header>Main Panel</header>
              {this.props.children}
            </div>
            <div>
              <header>Sidebar</header>
            </div>
          </div>
          <div>
            <Footer />
          </div>
        </div>
    )
  }
});

export default BasicLayout;

