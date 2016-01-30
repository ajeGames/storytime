module.exports = {
  entry: "./app/App.js",
  output: {
    filename: "../../../src/main/resources/webui/app-react/public/bundle.js"
  },
  devServer: {
    inline: true,
    port: 9555
  },
  module: {
    loaders: [
      {test: /\.css$/, loader: "style!css"},
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: "babel",
        query: {
          presets: ['es2015', 'react']
        }
      }
    ]
  }
};
