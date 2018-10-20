package br.edu.undra.keyhandler;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Um utilitario handler de teclas.
 * <br>
 *
 * @author alexandre
 */
public final class KeyHandler {

    private final Map<Integer, Runnable> keyHandlerMap = new HashMap();
    //algumas teclas mais comuns
    public final static int ESCAPE = KeyEvent.VK_ESCAPE;
    public final static int ENTER = KeyEvent.VK_ENTER;
    public final static int UP = KeyEvent.VK_UP;
    public final static int DOWN = KeyEvent.VK_DOWN;

    public KeyHandler() {
    }

    public KeyHandler( int[] keys , Runnable[] handlers) throws Exception{
        
        if( handlers == null || keys == null ) throw new NullPointerException("Os argumentos devem ser ambos NÃO nulos.");
        
        int keysNum = keys.length;
        int handlersNum = handlers.length;
        
        if ( keysNum != handlersNum ) throw new IllegalArgumentException(" O número de chaves DEVE SER IGUAL ao número de handlers.Passados chaves:"+keysNum + " handlers:"+handlersNum );
        
        for( int key = 0 ; key < keysNum; key++ ){
            
            addHandler(key, handlers[key]);
            
        }
        
    }
    
    
    
    
    public void addHandler(int key, Runnable handler) {
        
        if (!keyHandlerMap.containsKey(key)) {
            keyHandlerMap.put(key, handler);
        }
        
    }

    public Runnable removeHandler(int key) {

        Runnable handler = null;

        if (keyHandlerMap.containsKey(key)) {
            handler = keyHandlerMap.get(key);
            keyHandlerMap.remove(key);
        }

        return handler;

    }
    
    public void executeHandler( int key ) throws Exception{
        
        if ( ! keyHandlerMap.containsKey(key) ) {
            return;
        }
        
        try {
            
            keyHandlerMap.get(key).run();
            
        } catch (Exception e) {
            throw e;
        }
        
    }

}
