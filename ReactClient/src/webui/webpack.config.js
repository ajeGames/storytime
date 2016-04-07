var webpack = require('webpack');

module.exports = {
  entry: [
    'webpack-dev-server/client?http://localhost:8080',
    'webpack/hot/only-dev-server',
    './app/index.jsx'
  ],
  module: {
    loaders: [
      {test: /\.css$/, loader: "style!css"},
      {
        test: /\.jsx$/,
        exclude: /node_modules/,
        loader: 'react-hot!babel'
      }
    ]
  },
  resolve: {
    extensions: ['', '.js', '.jsx']
  },
  output: {
    path: __dirname + 'public',
    publicPath: '/',
    filename: 'bundle.js'
  },
  devServer: {
    contentBase: './public',
    hot: true
  },
  plugins: [
      new webpack.HotModuleReplacementPlugin()
  ]
};
