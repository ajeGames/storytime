import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Money from './Money';

const BasicLayout = (props) => (
  <div>
    <Header heading="Hey, kids!  Let's have an adventure!" />
    <main>
      {props.children}
    </main>
    <Money />
    <Footer />
  </div>
);

BasicLayout.propTypes = {
  children: React.PropTypes.node,
};

export default BasicLayout;

