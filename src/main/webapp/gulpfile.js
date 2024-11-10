// 引入gulp模块
var gulp = require("gulp")
// 引入gulp-rename模块：重命名
var rename = require("gulp-rename")
// 引入gulp-cssnano模块： 压缩css文件
var cssnano = require("gulp-cssnano")
// 引入gulp-uglify模块：压缩js文件
var uglify = require("gulp-uglify")
// 引入gulp-concat模块：合并文件
var concat = require("gulp-concat")
// 引入gulp-imagemin模块：压缩图片
var imagemin = require("gulp-imagemin")
// 引入gulp-cache模块：缓存压缩好的图片
var cache = require("gulp-cache")
// 引入browser-sync模块：创建服务器
var bs = require("browser-sync").create()
// 引入gulp-sass模块：将scss文件转化为css文件
var sass = require("gulp-sass")
// 引入gulp-util模块：其中的log方法可以打印js的错误信息
var util = require("gulp-util")
// 引入gulp-sourcemaps模块：js出错时浏览器会显示出错位置
var sourcemaps = require("gulp-sourcemaps")

var path = {
    // 'html': './templates/**/',
    'css': './src/css/**/',
    'js': './src/js/**/',
    'images': './src/images/**/',
    'css_dist': './dist/css/',
    'js_dist': './dist/js/',
    'images_dist': './dist/images/',
};

// gulp.task("html", function(){
//     gulp.src(path.html + '*.html')
//         .pipe(bs.stream());
// });


gulp.task("css", function() {
     gulp.src(path.css + '*.scss')
        .pipe(sass().on("error",sass.logError))
        .pipe(cssnano())
        .pipe(rename({"suffix":".min"}))
        .pipe(gulp.dest(path.css_dist))
        .pipe(bs.stream());
});


gulp.task('js',function(){
    gulp.src(path.js + '*.js')
        .pipe(sourcemaps.init())
        .pipe(uglify())
        .on("error",util.log)
        .pipe(rename({suffix:'.min'}))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(path.js_dist))
        .pipe(bs.stream());
});


gulp.task('images',function(){
    gulp.src(path.images + '*.*')
    .pipe(cache(imagemin()))
    .pipe(gulp.dest(path.images_dist))
    .pipe(bs.stream());
});


// 定义一个监听的任务
gulp.task("watch",function () {
    // 监听所有的css文件，然后执行css这个任务
    // gulp.watch(path.html + '*.html',['html']);
    gulp.watch(path.css + '*.scss', ['css']);
    gulp.watch(path.js + '*.js', ['js']);
    gulp.watch(path.images + '*.*', ['images']);
});


gulp.task("bs",function () {
    bs.init({
        'server': {
            'baseDir': './'
        }
    });
});


// 执行gulp server开启服务器
// gulp.task("default",['bs','watch']);
gulp.task("default",['watch']);