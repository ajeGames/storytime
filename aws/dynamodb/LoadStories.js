var fs = require('fs');
var path = require('path');

var repoPath = '../../repo';
var loadRepo = function() {
  var fileList;
  fs.readdir(repoPath, function(err, files) {
    if (err) {
      throw err;
    }
    fileList = files.map(function (file) {
      return path.join(repoPath, file);
    }).filter(function (file) {
      return fs.statSync(file).isFile();
    });
  });
  fileList.each(function(file) {
    console.log(file);
  });
};

loadRepo();
