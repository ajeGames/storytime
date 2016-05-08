import React from 'react'
import Header from './Header'
import Footer from './Footer'
import Money from './Money'

const BasicLayout = React.createClass({
  render: function () {
    return (
        <div>
          <Header heading="Hey, kids!  Let's have an adventure!" />
          <main>
            {this.props.children}
          </main>
          <Money />
          <Footer />
        </div>
    )
  }
});

export default BasicLayout;

