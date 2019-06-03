//https://www.typescriptlang.org/docs/handbook/gulp.html
var gulp = require('gulp')
var typescript = require('gulp-typescript')
var uglify = require('gulp-uglify')
var sourcemaps = require('gulp-sourcemaps');
var del = require('del')

var paths = {
    tsSource: './src/main/typescript',
    jsSource: './src/main/nodejs',
    tsDest: './build/ts'
}

var tsProject = typescript.createProject("tsconfig.json")

function compileTS() {
    return tsProject.src()
            .pipe(sourcemaps.init({ loadMaps: true }))
            .pipe(tsProject())
            .pipe(sourcemaps.write())
            .pipe(gulp.dest(paths.tsDest))
}

function cleanTS(){
    return del([paths.tsDest])
}

gulp.task("buildTS",gulp.series(cleanTS,compileTS));
gulp.task("default",gulp.parallel("buildTS"))