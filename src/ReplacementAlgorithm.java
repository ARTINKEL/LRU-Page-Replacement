/**
 * ReplacementAlgorithm.java 
 */


public abstract class ReplacementAlgorithm
{
	// the number of page faults
	protected int pageFaultCount;
	
	// the number of physical page frame
	protected int pageFrameCount;
	
	/**
	 * @param pageFrameCount - the number of physical page frames
	 */
	public ReplacementAlgorithm(int pageFrameCount) {
		if (pageFrameCount < 0)
			throw new IllegalArgumentException();
		
		this.pageFrameCount = pageFrameCount;
		pageFaultCount = 0;
	}
	
	/**
	 * @return - the number of page faults that occurred.
	 */
	public int getPageFaultCount() {
		return pageFaultCount;
	}
	
	/**
	 * @param pageNumber - the page number to be inserted
	 */
	public abstract void insert(int pageNumber); 
}
