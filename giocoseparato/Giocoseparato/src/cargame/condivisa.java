/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

/**
 *
 * @author sireci_edoardo
 */
public class condivisa  {
    public int vett[];
    private int num1=400;
    
    
    public condivisa() {
        vett=new int[]{400,-200,-500,100,-300,500};
        num1=util.RandomRange(0, 499);
    }

    public int getTree1ypos() {
        return vett[0];
    }

    public int getTree2ypos() {
        return vett[1];
    }

    public int getTree3ypos() {
        return vett[2];
    }

    public int getTree4ypos() {
        return vett[3];
    }

    public int getTree5ypos() {
        return vett[4];
    }

    public int getTree6ypos() {
        return vett[5];
    }

    public void setTree1ypos(int tree1ypos) {
        this.vett[0] = tree1ypos;
    }

    public void setTree2ypos(int tree2ypos) {
        this.vett[1] = tree2ypos;
    }

    public void setTree3ypos(int tree3ypos) {
        this.vett[2] = tree3ypos;
    }

    public void setTree4ypos(int tree4ypos) {
        this.vett[3] = tree4ypos;
    }

    public void setTree5ypos(int tree5ypos) {
        this.vett[4] = tree5ypos;
    }

    public void setTree6ypos(int tree6ypos) {
        this.vett[5] = tree6ypos;
    }
    
    public int riposizionamentoAlberi(){
            
        if(vett[0]>700)
	{
		num1=util.RandomRange(0, 499);
		vett[0]=-num1;
                return vett[0];    
	}
	if(vett[1]>700)
	{
		num1=util.RandomRange(0, 499);
		vett[1]=-num1;
                return vett[1];
	}
	if(vett[2]>700)
	{
		num1=util.RandomRange(0, 499);
		vett[2]=-num1;
                return vett[2];
	}
	if(vett[3]>700)
	{
		num1=util.RandomRange(0, 499);
		vett[3]=-num1;
                return vett[3];
	}
	if(vett[4]>700)
	{
		num1=util.RandomRange(0, 499);
		vett[4]=-num1;
                return vett[4];
	}
	if(vett[5]>700)
	{
		num1=util.RandomRange(0, 499);
		vett[5]=-num1;
                return vett[5];
	}
        return -1;
        }
    
    public void incrementopos(){
    vett[0]+=50;
    vett[1]+=50;
    vett[2]+=50;
    vett[3]+=50;
    vett[4]+=50;
    vett[5]+=50;
    
    
    }
        
      
}
