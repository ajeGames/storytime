const fs = require('fs');
const path = require('path');

const repoPath = '../../repo';
const loadRepo = () => {
  let fileList;
  fs.readdir(repoPath, (err, files) => {
    if (err) {
      throw err;
    }
    fileList = files.map(file => {
      return path.join(repoPath, file);
    }).filter(function (file) {
      return fs.statSync(file).isFile();
    });
  });
  fileList.each((file) => console.log(file));
};

loadRepo();
