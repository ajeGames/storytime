module.exports = {
  entry: "./app/components/Reader.js",
  output: {
    filename: "public/bundle.js"
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
