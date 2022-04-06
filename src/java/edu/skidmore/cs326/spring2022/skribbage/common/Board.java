package edu.skidmore.cs326.spring2022.skribbage.common;
import org.apache.log4j.Logger;

import us.daveread.edu.graphics.shape.impl.Image;
/**
 * 
 * @author Sten Leinasaar
 *
 */
public class Board {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;
    /**
     * Board image attribute.
     */
    private Image board;
    /**
     * Array of pegs.
     */
    //private Peg[] pegs;
    
    static {
        LOG = Logger.getLogger(Board.class);
    }
    /**
     * Constructor.
     */
    public Board() {
        
    }
    
//    public Spot[] getGrid() {
//        
//    }
//    public Peg[] getPegs() {
//        
//    }
//    public Spot[] getOccupiedSpots() {
//        
//    }
//    public Peg getSpot(Peg p) {
//        
//    }
//    public Spot assignPrizeSpot() {
//        
//    }
//    public Spot assignBattleSpot() {
//        
//    }
//    public Spot assignJumpSpot() {
//        
//    }
    
    
}
