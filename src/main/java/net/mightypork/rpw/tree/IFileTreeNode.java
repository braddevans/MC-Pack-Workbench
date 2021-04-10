package net.mightypork.rpw.tree;

public interface IFileTreeNode {

    /**
     * Get if this node is a directory node.
     *
     * @return is directory
     */
    boolean isDirectory();

    /**
     * Get if this node is a file node.
     *
     * @return is file
     */
    boolean isFile();

    boolean isSound();

    boolean isImage();

    boolean isText();

    boolean isJson();
}
