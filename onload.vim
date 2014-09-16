"" Vim project configuration script

if &ft ==? 'java'
    setlocal omnifunc=javacomplete#Complete
    setlocal completefunc=javacomplete#CompleteParamsInfo
endif

"" The following configuration can be done just once
if exists('g:did_simple_java')
    finish
endif
let g:did_simple_java = 1

"" ApplyTemplate configuration
let g:atpl_UsersList['@AUTHORMAIL@'] = '<aantonello@paralaxe.com.br>'
let g:atpl_UsersList['@PROJECT@']    = 'Simple (Java) Framework'
let g:atpl_UsersList['@PACKAGE@']    = 'sf'
let g:atpl_UsersList['@VERSION@']    = '2.5'
let g:atpl_UsersList['@OWNER@']      = 'Paralaxe Tecnologia'

"" Special highlighting configuration
let java_highlight_java_lang_ids = 1
let java_ignore_javadoc = 1

"" javacomplete configuration
let java_home = expand('$JAVA_HOME')

" call javacomplete#AddClassPath(android_home.'/platforms/android-19/android.jar')
call javacomplete#AddClassPath(java_home)
call javacomplete#AddSourcePath(getcwd().'/src/sf')
call javacomplete#SetSearchdeclMethod(4)

"" Special group to configure new files
augroup SIMPLE
    au BufNewFile *.java set syntax=java.doxygen nobomb
augroup END
